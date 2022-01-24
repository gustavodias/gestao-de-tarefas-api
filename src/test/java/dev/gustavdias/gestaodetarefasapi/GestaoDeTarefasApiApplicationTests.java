package dev.gustavdias.gestaodetarefasapi;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@SpringBootTest
class GestaoDeTarefasApiApplicationTests {

	@Test
	void contextLoads() throws ParseException {
		LocalDateTime date = LocalDateTime.now().plusDays(3);
		System.out.println(date);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		String agoraFormatado = date.format(formatter);

		System.out.println(agoraFormatado);

		/*LocalDate localDate = LocalDate.of();
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");


		Date data = formato.parse("Tue Nov 23 00:00:00 BRT 2021");

		System.out.println(data);
		System.out.println(formato.format(data));*/
	}

}
