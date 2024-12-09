package co.kr.oneweeks.demo.vo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
// @Log4j2
public class MemberTests {
    // private Member member = Member.builder().build();
    Member m1 = new Member("abcd", "1234", "dd");
    Member m2 = new Member("abcd", "1234", "dd");

    @Test
    public void testMember() {
        //given


        // Member m1 = Member.builder().id("abcd").pw("1234").name("dd").build();
        // Member m2 = Member.builder().id("abcd").pw("1234").name("dd").build();

        //when ~ then
        // log.info(String.format("%s@%X", m1.getClass().getName(), m1.hashCode()) );
        // log.info(String.format("%s@%X", m2.getClass().getName(), m2.hashCode()) );
        // expect / assert
        assertEquals(m1, m2);
        System.out.println(m2);
        assertSame(m1, m2);

    }
    @Autowired
    private Member member;
    @Test
    public void testDI() {
        System.out.println(member);
    }
}
