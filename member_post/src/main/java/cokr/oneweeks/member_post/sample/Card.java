package cokr.oneweeks.member_post.sample;

import java.util.Arrays;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Card {
	Kind kind;
	
	public static void main(String[] args) {
		Kind[] kinds = Kind.values();
		System.out.println(Arrays.toString(kinds));
		
		for(Kind k : kinds) {
			System.out.println(k.getName());
			
		}
	}
}
