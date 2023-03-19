package com.goofy.bot.infrastructure

import com.goofy.bot.domain.TargetMetadata
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TargetMetadataRepository : JpaRepository<TargetMetadata, Long>
