package Utils.DataReader;

import Utils.Logs.LogsManager;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class JsonReader {
    private String jsonReader;
    private final String jsonFileName;
    private static final String TEST_DATA_PATH =
            System.getProperty("user.dir") + "/src/test/resources/test-data/";

    public JsonReader(String jsonFileName) {
        this.jsonFileName = jsonFileName;

        try {
            File file = new File(TEST_DATA_PATH + jsonFileName + ".json");
            System.out.println("Trying to read JSON from: " + file.getAbsolutePath());

            if (!file.exists()) {
                throw new RuntimeException("JSON file not found at: " + file.getAbsolutePath());
            }

            JSONObject data = (JSONObject) new JSONParser().parse(new FileReader(file));
            jsonReader = data.toJSONString();

            LogsManager.info("JSON file loaded successfully: " + jsonFileName);

        } catch (Exception e) {
            LogsManager.error("Error while reading JSON file: ", jsonFileName, e.getMessage());
            jsonReader = "{}";
        }
    }

    public String getJsonData(String jsonPath) {
        try {
            return JsonPath.read(jsonReader, jsonPath);
        } catch (Exception e) {
            LogsManager.error("Error while reading JSON path " + jsonPath + " from file " + jsonFileName + ": ", e.getMessage());
            return null;
        }
    }
    public boolean updateJsonValue(String jsonPath, Object newValue) {
        File file = new File(TEST_DATA_PATH + jsonFileName + ".json");
        try {

            DocumentContext context = JsonPath.parse(jsonReader);
            context.set(jsonPath, newValue);
            jsonReader = context.jsonString();
            try (FileWriter writer = new FileWriter(file)) {
                writer.write(jsonReader);
            }
            LogsManager.info("Successfully updated JSON value at path " + jsonPath +
                    " in file: " + jsonFileName + " → New value: " + newValue);
            return true;
        } catch (Exception e) {
            LogsManager.error("Failed to update JSON value at path " + jsonPath +
                    " in file " + jsonFileName + ": ", e.getMessage());
            return false;
        }
    }
}
