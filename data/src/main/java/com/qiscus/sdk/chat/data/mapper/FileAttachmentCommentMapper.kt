/*
 * Copyright (c) 2016 Qiscus.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.qiscus.sdk.chat.data.mapper

import com.qiscus.sdk.chat.data.model.CommentStateEntity
import com.qiscus.sdk.chat.data.model.CommentTypeEntity
import com.qiscus.sdk.chat.data.model.FileAttachmentCommentEntity
import com.qiscus.sdk.chat.domain.model.CommentState
import com.qiscus.sdk.chat.domain.model.CommentType
import com.qiscus.sdk.chat.domain.model.FileAttachmentComment
import java.util.*

/**
 * Created on : August 19, 2017
 * Author     : zetbaitsu
 * Name       : Zetra
 * GitHub     : https://github.com/zetbaitsu
 */
fun FileAttachmentCommentEntity.toDomainModel(): FileAttachmentComment {
    return FileAttachmentComment(
            commentId.toDomainModel(),
            file,
            caption,
            message,
            sender.toDomainModel(),
            Date(nanoTimeStamp / 1000000),
            room.toDomainModel(),
            CommentState.valueOf(state.intValue),
            CommentType(type.rawType, type.payload)
    )
}

fun FileAttachmentComment.toEntity(): FileAttachmentCommentEntity {
    return FileAttachmentCommentEntity(
            commentId.toEntity(),
            file,
            caption,
            message,
            sender.toEntity(),
            date.time * 1000000,
            room.toEntity(),
            CommentStateEntity.valueOf(state.intValue),
            CommentTypeEntity(type.rawType, type.payload)
    )
}