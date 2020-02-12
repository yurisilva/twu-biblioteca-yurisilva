select name from member where id in (select member_id from checkout_item group by member_id having count(member_id) > 1);
