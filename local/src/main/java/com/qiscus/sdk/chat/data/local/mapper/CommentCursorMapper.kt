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

package com.qiscus.sdk.chat.data.local.mapper

import android.content.ContentValues
import android.database.Cursor
import com.qiscus.sdk.chat.data.local.database.Db
import com.qiscus.sdk.chat.data.local.database.intValue
import com.qiscus.sdk.chat.data.local.database.longValue
import com.qiscus.sdk.chat.data.local.database.stringValue
import com.qiscus.sdk.chat.data.mapper.transformToTypedCommentEntity
import com.qiscus.sdk.chat.data.model.*
import org.json.JSONObject

/**
 * Created on : September 05, 2017
 * Author     : zetbaitsu
 * Name       : Zetra
 * GitHub     : https://github.com/zetbaitsu
 */
fun CommentEntity.toContentValues(): ContentValues {
    return ContentValues().apply {
        put(Db.CommentTable.COLUMN_ID, commentId.id)
        put(Db.CommentTable.COLUMN_ROOM_ID, room.id)
        put(Db.CommentTable.COLUMN_UNIQUE_ID, commentId.uniqueId)
        put(Db.CommentTable.COLUMN_COMMENT_BEFORE_ID, commentId.commentBeforeId)
        put(Db.CommentTable.COLUMN_MESSAGE, message)
        put(Db.CommentTable.COLUMN_SENDER_ID, sender.id)
        put(Db.CommentTable.COLUMN_SENDER_NAME, sender.name)
        put(Db.CommentTable.COLUMN_SENDER_AVATAR, sender.avatar)
        put(Db.CommentTable.COLUMN_TIME, nanoTimeStamp)
        put(Db.CommentTable.COLUMN_STATE, state.intValue)
        put(Db.CommentTable.COLUMN_TYPE, type.rawType)
        put(Db.CommentTable.COLUMN_PAYLOAD, type.payload.toString())
    }
}

fun Cursor.toCommentEntity(): CommentEntity {
    return CommentEntity(
            CommentIdEntity(stringValue(Db.CommentTable.COLUMN_ID),
                    stringValue(Db.CommentTable.COLUMN_COMMENT_BEFORE_ID),
                    stringValue(Db.CommentTable.COLUMN_UNIQUE_ID)),
            stringValue(Db.CommentTable.COLUMN_MESSAGE),
            UserEntity(stringValue(Db.CommentTable.COLUMN_SENDER_ID),
                    stringValue(Db.CommentTable.COLUMN_SENDER_NAME),
                    stringValue(Db.CommentTable.COLUMN_SENDER_AVATAR)),
            longValue(Db.CommentTable.COLUMN_TIME),
            RoomEntity(stringValue(Db.CommentTable.COLUMN_ROOM_ID), name = "Unknown"),
            CommentStateEntity.valueOf(intValue(Db.CommentTable.COLUMN_STATE)),
            CommentTypeEntity(stringValue(Db.CommentTable.COLUMN_TYPE),
                    JSONObject(stringValue(Db.CommentTable.COLUMN_PAYLOAD)))
    ).transformToTypedCommentEntity()
}