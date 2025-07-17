create table WAFABAIL_Article (
	uuid_ VARCHAR(75) null,
	articleId LONG not null primary key,
	titre VARCHAR(75) null,
	detail VARCHAR(75) null,
	dateCreation DATE null
);