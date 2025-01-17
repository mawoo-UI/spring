package cokr.oneweeks.club.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cokr.oneweeks.club.entity.Likes;
import cokr.oneweeks.club.entity.composite.LikesId;

public interface LikesRepository extends JpaRepository<Likes, LikesId>{
  
}
