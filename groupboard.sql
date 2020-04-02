use groupboard;

create table account_due
(
    accountDuesID    int auto_increment
        primary key,
    groupID          int                                  not null,
    userID           int                                  not null,
    articleID        int                                  not null,
    accountDueAmount double                               not null,
    accounttitle     varchar(200)                         not null,
    uploadDate       datetime   default CURRENT_TIMESTAMP not null,
    updateDate       datetime                             null on update CURRENT_TIMESTAMP,
    paid             tinyint(1) default 0                 not null
);

create index articleID
    on account_due (articleID);

create index groupID
    on account_due (groupID);

create index userID
    on account_due (userID);

create table article
(
    articleUUID          varchar(36)                        null,
    articleID            int auto_increment
        primary key,
    groupID              int                                not null,
    userID               int                                not null,
    uploadDate           datetime default CURRENT_TIMESTAMP not null,
    updateDate           datetime                           null on update CURRENT_TIMESTAMP,
    articleContent       varchar(2000)                      not null,
    type                 int                                not null,
    vote_multiple        tinyint(1)                         null,
    vote_count           int                                null,
    schedule_subject     varchar(200)                       null,
    schedule_place       varchar(200)                       null,
    schedule_startDate   date                               null,
    schedule_endDate     date                               null,
    place_thumbnail_UUID varchar(36)                        null,
    place_coordinate_x   float                              null,
    place_coordinate_y   float                              null,
    place_address        varchar(200)                       null,
    accountSpent_amount  int                                null,
    accountDue_amount    int                                null,
    likeCount            int                                null,
    constraint articleUUID
        unique (articleUUID)
);

create index groupID
    on article (groupID);

create index userID
    on article (userID);

create table article_like
(
    articleID int                                not null,
    userID    int                                not null,
    likeDate  datetime default CURRENT_TIMESTAMP not null
);

create table `group`
(
    groupID    int auto_increment
        primary key,
    groupName  varchar(50)                        not null,
    url        varchar(200)                       not null,
    summary    varchar(200)                       null,
    createDate datetime default CURRENT_TIMESTAMP not null,
    groupColor int      default 0                 not null comment '0 = primary, 1 = secondary, 2=success, 3=danger, 4=warning, 5=info',
    manager    int                                not null,
    imgExt     varchar(12)                        null,
    constraint groupName
        unique (groupName),
    constraint group_url_uindex
        unique (url)
);

create index manager
    on `group` (manager);

create table image
(
    imageID    int auto_increment
        primary key,
    groupID    int                                not null,
    userID     int                                not null,
    articleID  int                                not null,
    uploadDate datetime default CURRENT_TIMESTAMP not null,
    filePath   varchar(200)                       not null
);

create index articleID
    on image (articleID);

create index groupID
    on image (groupID);

create index userID
    on image (userID);

create table image_reply
(
    imageReplyID      int auto_increment
        primary key,
    groupID           int                                not null,
    articleID         int                                null,
    userID            int                                not null,
    imageID           int                                not null,
    uploadDate        datetime default CURRENT_TIMESTAMP not null,
    updateDate        datetime                           null on update CURRENT_TIMESTAMP,
    imageRereplyID    int                                null,
    imageReplyContent varchar(1000)                      not null
);

create index groupID
    on image_reply (groupID);

create index imageID
    on image_reply (imageID);

create index userID
    on image_reply (userID);

create table reply
(
    groupID       int                                not null,
    articleID     int                                not null,
    replyID       int auto_increment
        primary key,
    parentReplyID int                                null,
    userID        int                                null,
    uploadDate    datetime default CURRENT_TIMESTAMP not null,
    updateDate    datetime                           null on update CURRENT_TIMESTAMP,
    replyContent  varchar(1000)                      null
);

create index articleID
    on reply (articleID);

create index groupID
    on reply (groupID);

create table schedule_attend
(
    articleID        int                                not null,
    scheduleAttendID int auto_increment
        primary key,
    userID           int                                not null,
    attend           tinyint(1)                         not null,
    uploadDate       datetime default CURRENT_TIMESTAMP not null
);

create index articleID
    on schedule_attend (articleID);

create index userID
    on schedule_attend (userID);

create table subscribe
(
    subscribeID     int auto_increment
        primary key,
    groupID         int                                not null,
    userID          int                                null,
    inviteDate      datetime default CURRENT_TIMESTAMP not null,
    inviteCode      varchar(12)                        not null,
    joinDate        datetime                           null,
    unsubscribeDate datetime                           null,
    constraint inviteCode
        unique (inviteCode)
);

create index groupID
    on subscribe (groupID);

create index inviteCode_2
    on subscribe (inviteCode);

create index userID
    on subscribe (userID);

create table user
(
    userID   int auto_increment
        primary key,
    email    varchar(200)                       not null,
    userName varchar(12)                        not null,
    pwd      varchar(60)                        not null,
    birthday date                               null,
    phone    varchar(11)                        null,
    joinDate datetime default CURRENT_TIMESTAMP not null,
    gravatar varchar(200)                       null,
    constraint email
        unique (email),
    constraint phone
        unique (phone)
);

create table vote_item
(
    articleID     int         not null,
    voteItemID    int auto_increment
        primary key,
    voteItemValue varchar(45) not null
);

create index articleID
    on vote_item (articleID);

create table vote_selected
(
    articleID      int                                not null,
    voteItemID     int                                not null,
    voteSelectedID int auto_increment
        primary key,
    userID         int                                not null,
    uploadDate     datetime default CURRENT_TIMESTAMP not null
);

create index articleID
    on vote_selected (articleID);

create index userID
    on vote_selected (userID);

create index voteContentID
    on vote_selected (voteItemID);

