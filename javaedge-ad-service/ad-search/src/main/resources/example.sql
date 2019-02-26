-- 更新, 插入, 删除 ad_plan
update ad_plan set start_date = '2018-11-30 00:00:00' where id = 10;

INSERT INTO `ad_plan` (`user_id`, `plan_name`, `plan_status`, `start_date`, `end_date`, `create_time`, `update_time`)
VALUES (10, '第二个推广计划', 1, '2018-01-01 00:00:00', '2019-12-01 00:00:00', '2018-01-01 00:00:00', '2018-01-01 00:00:00');

delete from ad_plan where id = 12;


-- 更新, 插入, 删除 ad_creative
update ad_creative set url = 'https://www.shishusheng.com';
INSERT INTO `ad_creative` (`name`, `type`, `material_type`, `height`, `width`, `size`, `duration`, `audit_status`, `user_id`, `url`, `create_time`, `update_time`) VALUES ('第二个创意', 1, 1, 720, 1080, 1024, 0, 1, 10, 'www.shishusheng.com', '2018-01-01 00:00:00', '2018-01-01 00:00:00');
delete from ad_creative where id = 13;


-- 更新, 插入, 删除 ad_unit
update ad_unit set unit_status = 1 where id = 10;
INSERT INTO `ad_unit` (`plan_id`, `unit_name`, `unit_status`, `position_type`, `budget`, `create_time`, `update_time`) VALUES (10, '第二个推广单元', 1, 1, 15000000, '2018-01-01 00:00:00', '2018-01-01 00:00:00');
delete from ad_unit where id = 11;


-- 插入, 删除 creative_unit
INSERT INTO `creative_unit` (`creative_id`, `unit_id`) VALUES (10, 12);
delete from creative_unit where creative_id = 10 and unit_id = 12;


-- 插入, 删除 ad_unit_district
INSERT INTO `ad_unit_district` (`unit_id`, `province`, `city`) VALUES (10, '辽宁省', '大连市');
delete from ad_unit_district where unit_id = 10 and province = '辽宁省' and city = '大连市';

-- 插入, 删除 ad_unit_it
INSERT INTO `ad_unit_it` (`unit_id`, `it_tag`) VALUES (10, '徒步');
delete from ad_unit_it where unit_id = 10 and it_tag = '徒步';

-- 插入, 删除 ad_unit_keyword
INSERT INTO `ad_unit_keyword` (`unit_id`, `keyword`) VALUES (10, '标志');
delete from ad_unit_keyword where unit_id = 10 and keyword = '标志';
