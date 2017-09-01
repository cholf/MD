## dead
mysql tables in use 3, locked 3
LOCK WAIT 4 lock struct(s), heap size 1184, 3 row lock(s)
MySQL thread id 121863253, OS thread handle 0x7fdcdfc30700, query id 70262515370 10.86.212.161 f_orderapp_w Searching rows for update
update n_order_info
        set last_updated = now(),
        allprices = 720,
        noPay = 0.0,
        pnr = '363951',
        child_pnr  = '000001',
        status = 2

            ,ticket_date = '2017-08-29 19:30:05'

        where order_no = 'sub170829192146775'
        and last_updated = '2017-08-29 19:30:02'
*** (1) WAITING FOR THIS LOCK TO BE GRANTED:
RECORD LOCKS space id 311764 page no 58284 n bits 360 index `update_time_idx` of table `com_qunar_trade_sub`.`n_order_info` trx id 75806016964 lock_mode X waiting
*** (2) TRANSACTION:
TRANSACTION 75806016963, ACTIVE 0 sec starting index read, thread declared inside InnoDB 4999
mysql tables in use 3, locked 3
5 lock struct(s), heap size 1184, 4 row lock(s)
MySQL thread id 121909066, OS thread handle 0x7fdcda55a700, query id 70262515369 10.86.212.163 f_orderapp_w Searching rows for update
update n_order_info
        set last_updated = now(),
        allprices = 900,
        noPay = 0.0,
        pnr = '363954',
        child_pnr  = '000001',
        status = 2

            ,ticket_date = '2017-08-29 19:30:05'

        where order_no = 'sub170829192151803'
        and last_updated = '2017-08-29 19:30:02'
*** (2) HOLDS THE LOCK(S):
RECORD LOCKS space id 311764 page no 58284 n bits 360 index `update_time_idx` of table `com_qunar_trade_sub`.`n_order_info` trx id 75806016963 lock_mode X
*** (2) WAITING FOR THIS LOCK TO BE GRANTED:
RECORD LOCKS space id 311764 page no 75515 n bits 120 index `PRIMARY` of table `com_qunar_trade_sub`.`n_order_info` trx id 75806016963 lock_mode X locks rec but not gap waiting
*** WE ROLL BACK TRANSACTION (1)
