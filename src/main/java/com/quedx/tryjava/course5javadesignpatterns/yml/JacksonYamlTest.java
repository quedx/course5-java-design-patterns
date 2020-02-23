package com.quedx.tryjava.course5javadesignpatterns.yml;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;
import com.quedx.tryjava.course5javadesignpatterns.yml.core.SealBuilder;
import com.quedx.tryjava.course5javadesignpatterns.yml.model.ElasticSearchParams;
import com.quedx.tryjava.course5javadesignpatterns.yml.model.Seal;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


@SpringBootTest
public class JacksonYamlTest {

	/**
	 * Write to yaml
	 * @param seal
	 * @param filePath
	 */
	public static <T> void writeToYaml(Seal<T> seal, String filePath) {
		ObjectMapper mapper = new ObjectMapper(new YAMLFactory().disable(YAMLGenerator.Feature.WRITE_DOC_START_MARKER));
		mapper.findAndRegisterModules();

		try {
			mapper.writeValue(new File(filePath), seal);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Write to yaml
	 * @param sealList
	 * @param filePath
	 */
	public static <T> void writeToYamlList(List<Seal<T>> sealList, String filePath) {
		ObjectMapper mapper = new ObjectMapper(new YAMLFactory().disable(YAMLGenerator.Feature.WRITE_DOC_START_MARKER));
		mapper.findAndRegisterModules();

		try {
			mapper.writeValue(new File(filePath), sealList);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	/**
	 * Read from yaml
	 * @param filePath
	 * @return
	 */
	public static Seal<ElasticSearchParams> readFromYaml(String filePath) {
		ObjectMapper mapper = new ObjectMapper(new YAMLFactory());

		Seal<ElasticSearchParams> seal = null;
		try {

			seal = mapper.readValue(new File(filePath),
					new TypeReference<Seal<ElasticSearchParams>>() {
						@Override
						public Type getType() {
							return super.getType();
						}
					});

		} catch (IOException e) {
			e.printStackTrace();
		}
		return seal;
	}

	/**
	 * Read from yaml
	 * @param filePath
	 * @return
	 */
	public static List<Seal<ElasticSearchParams>> readFromYamlList(String filePath) {
		ObjectMapper mapper = new ObjectMapper(new YAMLFactory());

		List<Seal<ElasticSearchParams>> sealList = null;
		try {

			sealList = mapper.readValue(new File(filePath),
					new TypeReference<List<Seal<ElasticSearchParams>>>() {
						@Override
						public Type getType() {
							return super.getType();
						}
					});

		} catch (IOException e) {
			e.printStackTrace();
		}
		return sealList;
	}

	@Test
	public void testWriterAndReader() {

		String yamlFilePath = "src/main/resources/seal-out.yaml";
		Seal<ElasticSearchParams> sealIn = SealBuilder.newSeal();
		writeToYaml(sealIn, yamlFilePath);

		Seal<ElasticSearchParams> sealOut = readFromYaml(yamlFilePath);

		Assertions.assertEquals(sealIn.toString(), sealOut.toString());


	}

	@Test
	public void testWriterAndReaderList() {

		String yamlFilePath = "src/main/resources/seal-out-list.yaml";
		List<Seal<ElasticSearchParams>> sealInList = new ArrayList<>();
		sealInList.add(SealBuilder.newSeal());
		sealInList.add(SealBuilder.newSeal());

		writeToYamlList(sealInList, yamlFilePath);

		List<Seal<ElasticSearchParams>> sealOutList = readFromYamlList(yamlFilePath);

		Assertions.assertEquals(sealInList.toString(), sealOutList.toString());

	}

}
