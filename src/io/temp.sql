prompt Importing table c_city...
set feedback off
set define off
insert into c_city (C_CITY_ID, AD_CLIENT_ID, AD_ORG_ID, ISACTIVE, CREATED, CREATEDBY, UPDATED, UPDATEDBY, NAME, LOCODE, COORDINATES, POSTAL, AREACODE, C_COUNTRY_ID, C_REGION_ID)
values (10922, 0, 0, 'Y', to_date('05-03-2013 15:32:20', 'dd-mm-yyyy hh24:mi:ss'), 0, to_date('18-04-2014 09:56:11', 'dd-mm-yyyy hh24:mi:ss'), 54, 'Guang Zhou', null, null, '510000', null, 153, 10044);

prompt Done.
