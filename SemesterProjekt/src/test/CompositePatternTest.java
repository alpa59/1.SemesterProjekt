package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.*;

class CompositePatternTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void CompositePatterntest() {
		//arrange
		Composite comp = new Composite("Køkken", "", "4321", 0, 0, 0, 0,"Hvidevare");
		AbstractProduct sp = new SimpleProduct("Screws", null, "1", 0, 0, 0, 0, 0, 0);
		AbstractProduct sp1 = new SimpleProduct("Kabinets", null, "2", 0, 0, 0, 0, 0, 0);
		CompositeLine coli = new CompositeLine(5,sp,comp);
		CompositeLine coli1 = new CompositeLine(5,sp1,comp);
		comp.add(coli);
		comp.add(coli1);
		//act
		List<CompositeLine> cl = comp.getList();
		
		//assert
		assertEquals(cl.size(), 2);
		assertEquals(coli.getAmount(),5);
	}

}
