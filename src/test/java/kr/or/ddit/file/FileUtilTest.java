package kr.or.ddit.file;

import static org.junit.Assert.*;

import java.util.UUID;

import org.junit.Test;

import kr.or.ddit.util.FileUtil;

public class FileUtilTest {

	@Test
	public void getFileNameTest(){

	/***Given***/
	String ContentDisposition = "form-data; name=\"file\"; filename=\"brown.png\"";

	/***When***/
	String filename = FileUtil.getFileName(ContentDisposition);
	/***Then***/
	assertEquals("brown.png", filename);
	}
	
	@Test
	public void getFileNameFailTest() {

	/***Given***/
	String contentDisposition = "form-data; name=\"file\"; ";

	/***When***/
	String filename = FileUtil.getFileName(contentDisposition);
	/***Then***/
	assertEquals("", filename);
	}

	@Test
	public void getFileExtensionTest() {
		/***Given***/
		String filename ="brown.png";

		/***When***/
		String extension = FileUtil.getFileExtension(filename);
		/***Then***/
		assertEquals("png", extension);
	}
	
//	.이 2개인 파일인 경우 test
	@Test
	public void getFileExtensionTest2() {
		/***Given***/
		String filename ="line.brown.png";

		/***When***/
		String extension = FileUtil.getFileExtension(filename);
		/***Then***/
		assertEquals("png", extension);
	}
	// 확장자가 없는 경우 
	@Test
	public void getFileExtensionTest3() {
		/***Given***/
		String filename ="brown";

		/***When***/
		String extension = FileUtil.getFileExtension(filename);
		/***Then***/
		assertEquals("", extension);
	}
	
	
	
	@Test
	public void test() {
	System.out.println(UUID.randomUUID().toString());
	}
	
	
}
