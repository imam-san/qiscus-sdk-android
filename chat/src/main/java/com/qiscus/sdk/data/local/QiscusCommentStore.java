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

package com.qiscus.sdk.data.local;

import com.qiscus.sdk.data.model.QiscusComment;

import java.util.List;

import rx.Observable;

/**
 * Created on : November 07, 2016
 * Author     : zetbaitsu
 * Name       : Zetra
 * GitHub     : https://github.com/zetbaitsu
 */
public interface QiscusCommentStore {
    void add(QiscusComment qiscusComment);

    boolean isContains(QiscusComment qiscusComment);

    void update(QiscusComment qiscusComment);

    void addOrUpdate(QiscusComment qiscusComment);

    void delete(QiscusComment qiscusComment);

    void deleteCommentsByRoomId(int roomId);

    QiscusComment getComment(int id, String uniqueId);

    List<QiscusComment> getComments(int topicId);

    List<QiscusComment> getComments(int topicId, int count);

    Observable<List<QiscusComment>> getObservableComments(int topicId);

    Observable<List<QiscusComment>> getObservableComments(int topicId, int count);

    List<QiscusComment> getOlderCommentsThan(QiscusComment qiscusComment, int topicId, int count);

    Observable<List<QiscusComment>> getObservableOlderCommentsThan(QiscusComment qiscusComment, int topicId, int count);

    List<QiscusComment> getCommentsAfter(QiscusComment qiscusComment, int topicId);

    Observable<List<QiscusComment>> getObservableCommentsAfter(QiscusComment qiscusComment, int topicId);

    QiscusComment getLatestComment();

    QiscusComment getLatestComment(int roomId);

    QiscusComment getLatestDeliveredComment(int topicId);

    QiscusComment getLatestReadComment(int topicId);

    List<QiscusComment> getPendingComments();

    Observable<List<QiscusComment>> getObservablePendingComments();
}
