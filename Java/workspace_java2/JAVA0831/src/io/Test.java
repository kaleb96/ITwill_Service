package io;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class Test {

	public static void main(String[] args) {
		// 시스템의 현재 날짜를 얻어와서 xxxx-xx-xx 형식으로 변환하는 방법
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(sdf.format(d));
		
		// 랜덤한 고유번호 생성하는 방법
		String uid = UUID.randomUUID().toString();
		System.out.println(uid);
	}

}
