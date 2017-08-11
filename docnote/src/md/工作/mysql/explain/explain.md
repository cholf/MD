## Explain-Mysql
##### Result;
+—-+————-+——-+——+—————+——+———+——+——+——-+
| id | select_type | table | type | possible_keys | key | key_len | ref | rows | Extra |

- select_type:select查询的类型，主要是区别普通查询和联合查询、子查询之类的复杂查询。
  - SIMPLE:查询中不包含子查询或者UNION
  - 查询中若包含任何复杂的子部分，最外层查询则被标记为：PRIMARY
  - 在SELECT或WHERE列表中包含了子查询，该子查询被标记为：SUBQUERY
  - 在FROM列表中包含的子查询被标记为：DERIVED（衍生）
  - 若第二个SELECT出现在UNION之后，则被标记为UNION；若UNION包含在 FROM子句的子查询中，外层SELECT将被标记为：DERIVED
  - 从UNION表获取结果的SELECT被标记为：UNION RESULT

- table :输出的行所引用的表。
- type:联合查询所使用的类型，表示MySQL在表中找到所需行的方式，又称“访问类型”。
  - ALL: 扫描全表
  - index: 扫描全部索引树
  - range: 扫描部分索引，索引范围扫描，对索引的扫描开始于某一点，返回匹配值域的行，常见于between、<、>等的查询
  - ref: 非唯一性索引扫描，返回匹配某个单独值的所有行。常见于使用非唯一索引即唯一索引的非唯一前缀进行的查找
  - eq_ref：唯一性索引扫描，对于每个索引键，表中只有一条记录与之匹配。常见于主键或唯一索引扫描
  - const, system: 当MySQL对查询某部分进行优化，并转换为一个常量时，使用这些类型访问。如将主键置于where列表中，MySQL就能将该查询转换为一个常量。system是const类型的特例，当查询的表只有一行的情况下， 使用system。
  - NULL: MySQL在优化过程中分解语句，执行时甚至不用访问表或索引。



- possible_keys:指出MySQL能使用哪个索引在该表中找到行。查询涉及到的字段上若存在索引，则该索引将被列出，但不一定被查询使用。如果是空的，没有相关的索引。这时要提高性能，可通过检验WHERE子句，看是否引用某些字段，或者检查字段不是适合索引。
- key :显示MySQL实际决定使用的键。如果没有索引被选择，键是NULL。
- key_len:显示MySQL决定使用的键长度。表示索引中使用的字节数，可通过该列计算查询中使用的索引的长度。如果键是NULL，长度就是NULL。文档提示特别注意这个值可以得出一个多重主键里mysql实际使用了哪一部分。 注：key_len显示的值为索引字段的最大可能长度，并非实际使用长度，即key_len是根据表定义计算而得，不是通过表内检索出的。
ref:显示哪个字段或常数与key一起被使用。
- rows:这个数表示mysql要遍历多少数据才能找到，表示MySQL根据表统计信息及索引选用情况，估算的找到所需的记录所需要读取的行数，在innodb上可能是不准确的。
- Extra:包含不适合在其他列中显示但十分重要的额外信息。
  - Only index，这意味着信息只用索引树中的信息检索出的，这比扫描整个表要快。

  - using where是使用上了where限制，表示MySQL服务器在存储引擎受到记录后进行“后过滤”（Post-filter），如果查询未能使用索引，Using where的作用只是提醒我们MySQL将用where子句来过滤结果集。

  - impossible where 表示用不着where，一般就是没查出来啥。

  - Using filesort（MySQL中无法利用索引完成的排序操作称为“文件排序”）当我们试图对一个没有索引的字段进行排序时，就是filesoft。它跟文件没有任何关系，实际上是内部的一个快速排序。

  - Using temporary（表示MySQL需要使用临时表来存储结果集，常见于排序和分组查询），使用filesort和temporary的话会很吃力，WHERE和ORDER BY的索引经常无法兼顾，如果按照WHERE来确定索引，那么在ORDER BY时，就必然会引起Using filesort，这就要看是先过滤再排序划算，还是先排序再过滤划算。
