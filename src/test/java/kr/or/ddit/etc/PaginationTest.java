package kr.or.ddit.etc;

import static org.junit.Assert.*;

import org.junit.Test;

public class PaginationTest {

	@Test
	public void test() {
	
	/***Given***/
	int userTotcnt = 32;
	int pageSize = 5;

	/***When***/
//	int pagination = 5;

	// 나눠서 4라는 값이 나오도록 페이징 계산하기 
	int pagination  = (int)Math.ceil((double)userTotcnt/pageSize);
	System.out.println(pagination);
	
	/***Then***/
	assertEquals(7, pagination);
	
	}

}
