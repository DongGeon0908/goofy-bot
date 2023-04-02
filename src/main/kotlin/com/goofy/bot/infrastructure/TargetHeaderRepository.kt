package com.goofy.bot.infrastructure

import com.goofy.bot.domain.TargetHeader
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TargetHeaderRepository : JpaRepository<TargetHeader, Long>
