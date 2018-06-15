# Write your MySQL query statement below
select
ifnull(round((select count(*) from (select distinct requester_id, accepter_id from request_accepted) as A) /
             (select count(*) from (select distinct sender_id, send_to_id from friend_request) as B), 2), 0)
             as accept_rate;