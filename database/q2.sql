select count(distinct name) from member where id not in (select distinct member_id from checkout_item);