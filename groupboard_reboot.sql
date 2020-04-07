CREATE TABLE `user` (
	`userID`	int	NOT NULL	primary key auto_increment,
	`email`	varchar(200)	NOT NULL,
	`userName`	varchar(12)	NOT NULL,
	`pwd`	varchar(60)	NOT NULL,
	`birthday`	date	NULL,
	`phone`	varchar(11)	NULL,
	`joinDate`	datetime	NOT NULL	DEFAULT	CURRENT_TIMESTAMP,
	`userImageUUID`	varchar(200)	NULL
);
CREATE TABLE `group` (
	`groupID`	int	NOT NULL	primary key auto_increment,
	`userID`	int	NOT NULL,
	`groupName`	varchar(50)	NOT NULL,
	`summary`	varchar(200)	NULL,
	`createDate`	datetime	NOT NULL	DEFAULT	CURRENT_TIMESTAMP,
	`groupColor`	int	NOT NULL	DEFAULT '0'	COMMENT '0 = primary, 1 = secondary, 2=success, 3=danger, 4=warning, 5=info',
	`manager`	int	NOT NULL,
	`imgExt`	varchar(12)	NULL,
	`groupUUID`	varchar(36)	NOT NULL
);
CREATE TABLE `subscribe` (
	`subscribeID`	int	NOT NULL	primary key auto_increment,
	`groupID`	int	NOT NULL,
	`userID`	int	NOT NULL,
	`inviteDate`	datetime	NOT NULL	DEFAULT	CURRENT_TIMESTAMP,
	`inviteCode`	varchar(12)	NOT NULL,
	`joinDate`	datetime	NULL,
	`unsubscribeDate`	datetime	NULL
);





CREATE TABLE `article` (
	`articleID`	int	NOT NULL	primary key auto_increment,
	`userID`	int	NOT NULL,
	`groupID`	int	NOT NULL,
	`uploadDate`	datetime	NOT NULL	DEFAULT	CURRENT_TIMESTAMP,
	`updateDate`	datetime	NULL	DEFAULT NULL	on update	CURRENT_TIMESTAMP,
	`articleContent`	varchar(2000)	NOT NULL,
	`type`	int	NOT NULL,
	`likeCount`	int	NULL
);
CREATE TABLE `article_like` (
	`likeDate`	datetime	NOT NULL	DEFAULT	CURRENT_TIMESTAMP,
	`articleID`	int	NOT NULL,
	`userID`	int	NOT NULL
);
CREATE TABLE `reply` (
	`replyID`	int	NOT NULL	primary key auto_increment,
	`articleID`	int	NOT NULL,
	`userID`	int	NOT NULL,
	`groupID`	int	NOT NULL,
	`parentReplyID`	int	NULL,
	`uploadDate`	datetime	NOT NULL	DEFAULT	CURRENT_TIMESTAMP,
	`updateDate`	datetime	NULL	DEFAULT NULL	ON	UPDATE	CURRENT_TIMESTAMP,
	`replyContent`	varchar(1000)	NULL
);





CREATE TABLE `image` (
	`imageID`	int	NOT NULL	primary key auto_increment,
	`groupID`	int	NOT NULL,
	`articleID`	int	NOT NULL,
	`uploadDate`	datetime	NOT NULL	DEFAULT	CURRENT_TIMESTAMP,
	`filePath`	varchar(200)	NOT NULL,
	`album`	boolean	NULL
);
CREATE TABLE `image_reply` (
	`imageReplyID`	int	NOT NULL	primary key auto_increment,
	`imageID`	int	NOT NULL,
	`userID`	int	NOT NULL,
	`uploadDate`	datetime	NOT NULL	DEFAULT	CURRENT_TIMESTAMP,
	`updateDate`	datetime	NULL	DEFAULT NULL	ON UPDATE	CURRENT_TIMESTAMP,
	`imageReplyContent`	varchar(1000)	NOT NULL
);





CREATE TABLE `vote` (
	`voteID`	int	NOT NULL	primary key auto_increment,
	`articleID`	int	NOT NULL,
	`multiple`	tinyint(1)	NOT NULL,
	`count`	int	NULL,
	`groupVote`	boolean	NULL
);
CREATE TABLE `vote_item` (
	`voteItemID`	int	NOT NULL	primary key auto_increment,
	`voteID`	int	NOT NULL,
	`count`	int	NULL,
	`voteItemValue`	varchar(45)	NOT NULL
);
CREATE TABLE `vote_selected` (
	`voteItemID`	int	NOT NULL	primary key auto_increment,
	`userID`	int	NOT NULL,
	`uploadDate`	datetime	NOT NULL	DEFAULT	CURRENT_TIMESTAMP
);





CREATE TABLE `Schedule` (
	`ScheduleID`	int	NOT NULL	primary key auto_increment,
	`articleID`	int	NOT NULL,
	`groupID2`	int	NOT NULL,
	`articleUUID`	varchar(36)	NULL,
	`userid`	int	NULL,
	`subject`	varchar(200)	NULL,
	`startDate`	date	NULL,
	`endDate`	date	NULL,
	`groupSchedule`	boolean	NULL
);
CREATE TABLE `schedule_attendPersone` (
	`scheduleAttendID`	int	NOT NULL	primary key auto_increment,
	`ScheduleID`	int	NOT NULL,
	`userID`	int	NOT NULL,
	`attend`	tinyint(1)	NOT NULL,
	`uploadDate`	datetime	NOT NULL	DEFAULT	CURRENT_TIMESTAMP
);





CREATE TABLE `place` (
	`placeID`	int	NOT NULL	primary key auto_increment,
	`articleID`	int	NOT NULL,
	`groupID`	int	NOT NULL,
	`uploadDate`	datetime	NULL	DEFAULT	CURRENT_TIMESTAMP,
	`thumbnailImage_UUID`	varchar(36)	NULL,
	`coordinate_x`	float	NULL,
	`coordinate_y`	float	NULL,
	`address`	float	NULL,
	`userID`	int	NULL,
	`groupMap`	boolean	NULL
);


INSERT INTO