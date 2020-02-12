insert into book values (11, 'The Pragmatic Programmer');
insert into member values (43, 'Yuri Silva');
insert into checkout_item(member_id, book_id) values (43, 11);
select name from member m join checkout_item c on c.member_id = m.id where c.book_id = (select id from book where title = 'The Pragmatic Programmer');