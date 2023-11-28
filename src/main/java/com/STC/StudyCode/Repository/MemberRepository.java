package com.STC.StudyCode.Repository;

import com.STC.StudyCode.Entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberEntity, String> {

}
