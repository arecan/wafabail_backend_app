create table WAFABAIL_Revue (
	uuid_ VARCHAR(75) null,
	revueId LONG not null primary key,
	titre VARCHAR(75) null,
	details VARCHAR(75) null,
	lien VARCHAR(75) null,
	dateCreation DATE null
);