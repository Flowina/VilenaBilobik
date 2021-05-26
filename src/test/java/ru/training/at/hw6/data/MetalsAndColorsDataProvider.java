package ru.training.at.hw6.data;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.DataProvider;
import ru.training.at.hw6.entities.MetalsAndColorsDataItem;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class MetalsAndColorsDataProvider {
    private final String jsonPath = "src/test/resources/hw6/JDI_ex8_metalsColorsDataSet.json";

    @DataProvider(name = "JDI_ex8_metalsColorsDataSet.json")
    public Object[][] data() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<HashMap<String, MetalsAndColorsDataItem>> typeRef
                = new TypeReference<HashMap<String, MetalsAndColorsDataItem>>() {};
        HashMap<String, MetalsAndColorsDataItem> map = objectMapper
                .readValue(new File(jsonPath), typeRef);
        Object[][] result = new Object[map.size()][1];
        int i = 0;
        for (Object item : map.values()) {
            result[i][0] = item;
            i++;
        }
        return result;
    }
}
