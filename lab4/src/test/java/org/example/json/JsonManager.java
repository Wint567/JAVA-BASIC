package org.example.json;

import com.google.gson.*;
import org.example.model.*;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;

public class JsonManager {

    // Ініціалізація об'єкта Gson з налаштуваннями для форматування та адаптера для серіалізації/десеріалізації класу Human
    private static final Gson gson = new GsonBuilder()
            .setPrettyPrinting()  // Додає красиве форматування для виводу JSON
            .registerTypeAdapter(Human.class, new HumanAdapter())  // Регіструємо власний адаптер для класу Human
            .create();  // Створюємо об'єкт Gson з вказаними налаштуваннями

    // Метод для серіалізації об'єкта University в JSON формат та запису в файл
    public static void saveToFile(University university, String filename) throws IOException {
        // Використовуємо FileWriter для запису в файл
        try (FileWriter writer = new FileWriter(filename)) {
            // Перетворюємо об'єкт university в JSON і записуємо в файл
            gson.toJson(university, writer);
        }
    }

    // Метод для десеріалізації JSON з файлу в об'єкт University
    public static University loadFromFile(String filename) throws IOException {
        // Використовуємо FileReader для зчитування з файлу
        try (FileReader reader = new FileReader(filename)) {
            // Перетворюємо JSON з файлу в об'єкт типу University
            return gson.fromJson(reader, University.class);
        }
    }

    // Внутрішній клас, який реалізує адаптер для серіалізації та десеріалізації класу Human
    private static class HumanAdapter implements JsonSerializer<Human>, JsonDeserializer<Human> {

        // Метод для серіалізації об'єкта Human в JSON
        @Override
        public JsonElement serialize(Human src, Type typeOfSrc, JsonSerializationContext context) {
            // Перетворюємо об'єкт в JSON об'єкт
            JsonObject jsonObject = context.serialize(src).getAsJsonObject();
            // Додаємо додаткове поле "type", яке вказує на реальний клас об'єкта
            jsonObject.addProperty("type", src.getClass().getSimpleName());
            return jsonObject;
        }

        // Метод для десеріалізації JSON в об'єкт Human
        @Override
        public Human deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            // Отримуємо JSON об'єкт
            JsonObject jsonObject = json.getAsJsonObject();
            // Отримуємо значення поля "type" для визначення реального класу
            String type = jsonObject.get("type").getAsString();
            // Вибір класу в залежності від значення "type"
            Class<? extends Human> clazz = "Student".equals(type) ? Student.class : Human.class;
            // Десеріалізуємо JSON в об'єкт відповідного класу
            return context.deserialize(json, clazz);
        }
    }
}
