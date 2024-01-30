package com.macro.mall.tiny;

import com.macro.mall.tiny.modules.xd.dto.XdUserParams;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;


public class fwhTest {
    public static void main(String[] args) {
        XdUserParams userParams = new XdUserParams();

        userParams.setId(1L);
        userParams.setUid(123456L);
        userParams.setUserName("John Doe");
        userParams.setAvatarImage("http://example.com/johndoe.png");
        userParams.setSex(true);
        userParams.setAge(30);
        userParams.setYear(1991);
        userParams.setMonth(12);
        userParams.setDay(31);
        userParams.setConstellation("Capricorn");
        userParams.setHeight(180);
        userParams.setWeight(75);
        userParams.setEducation("Bachelor's Degree");
        userParams.setSchool("Example University");
        userParams.setJob("Software Engineer");
        userParams.setAddress("123 Example Street, Example City");
        userParams.setHometown("Example Town");
        userParams.setIncome("50000");
        userParams.setMarriage("Single");
        userParams.setDeleted(false);

        ObjectMapper mapper = new ObjectMapper();
        try {
            String jsonString = mapper.writeValueAsString(userParams);
            System.out.println(jsonString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public String getUid() {
        String uid = "1";
        for (int i = 0; i < 8; i++) {
            uid += (int) (Math.random() * 10);
        }
        return uid;
    }

//    生成八位uid数值
    @Test
    public void testUid() {
        String uid = "";
        for (int i = 0; i < 8; i++) {
            uid += (int) (Math.random() * 10);
        }
        System.out.println(uid);
    }

//    雪花算法生成八位uid
//    @Test
//    public void testSnowflake() {
//        SnowflakeIdWorker idWorker = new SnowflakeIdWorker(0, 0);
//        System.out.println(idWorker.nextId());
//    }
//    @Test
//    public void testSnowflake() {
//        SnowflakeIdWorker idWorker = new SnowflakeIdWorker(1, 1);
//        for (int i = 0; i < 10; i++) {
//            System.out.println(idWorker.nextId());
//        }
//    }
}