
#### ubuntu下参考可如下链接使用qtcreator配置nginx源码阅读、编译、调试环境

http://www.ithao123.cn/content-678221.html
https://my.oschina.net/eechen/blog/166969

- 下载安装 qt安装

- nginx源码下载

- 解压nginx源码，源码目录下执行  ./configure --prefix=./objs  , 生成 ngx_modules.c、ngx_auto_config.h、ngx_auto_headers.h、Makefile 等文件，这些文件都在./objs 目录里

-  qt-新建项目-其它项目-创建空白项目

-  把nginx目录下的src、objs目录拷贝到这个新建的目录下面

-   将这个qt项目的 .pro文件弄成后面给的配置

-  点击 qtcreator锤子，就可以编译了

-  编译好后，通过命令行  sudo  ./objs/nginx 来执行

-  浏览器127.0.0.1 可以看到 Welcome to nginx!

- 当然可以调试玩了

#### 编译错误整理
#### 附录， 我的.pro配置，  这里面没有包含所有的.c文件，包含后编译报错不通过
-  error: collect2: error: ld returned 1 exit  status  -- detail-error: ngx_modules.o:(.data.rel+0x78)：对‘ngx_http_limit_zone_module’未定义的引用
-
    - 解决方案:objs 去掉这个模块
-   cannot find -lGL
    - 解决方案: sudo apt-get install libgl1-mesa-dev


TARGET = nginx
DESTDIR = objs
LIBS = -lpthread -lcrypt -lpcre -lcrypto -lcrypto -lz
INCLUDEPATH += \
        src/core \
        src/event \
        src/event/modules \
        src/os/unix \
        src/http/modules \
        src/http \
        objs
HEADERS = src/core/ngx_config.h \
        src/core/ngx_core.h \
        src/core/ngx_log.h \
        src/core/ngx_palloc.h \
        src/core/ngx_array.h \
        src/core/ngx_list.h \
        src/core/ngx_hash.h \
        src/core/ngx_buf.h \
        src/core/ngx_queue.h \
        src/core/ngx_string.h \
        src/core/ngx_parse.h \
        src/core/ngx_inet.h \
        src/core/ngx_file.h \
        src/core/ngx_crc.h \
        src/core/ngx_crc32.h \
        src/core/ngx_murmurhash.h \
        src/core/ngx_md5.h \
        src/core/ngx_sha1.h \
        src/core/ngx_rbtree.h \
        src/core/ngx_radix_tree.h \
        src/core/ngx_slab.h \
        src/core/ngx_times.h \
        src/core/ngx_shmtx.h \
        src/core/ngx_connection.h \
        src/core/ngx_cycle.h \
        src/core/ngx_conf_file.h \
        src/core/ngx_resolver.h \
        src/core/ngx_open_file_cache.h \
        src/core/ngx_crypt.h \
        src/event/ngx_event.h \
        src/event/ngx_event_timer.h \
        src/event/ngx_event_posted.h \
        src/event/ngx_event_busy_lock.h \
        src/event/ngx_event_connect.h \
        src/event/ngx_event_pipe.h \
        src/os/unix/ngx_time.h \
        src/os/unix/ngx_errno.h \
        src/os/unix/ngx_alloc.h \
        src/os/unix/ngx_files.h \
        src/os/unix/ngx_channel.h \
        src/os/unix/ngx_shmem.h \
        src/os/unix/ngx_process.h \
        src/os/unix/ngx_setproctitle.h \
        src/os/unix/ngx_atomic.h \
        src/os/unix/ngx_gcc_atomic_x86.h \
        src/os/unix/ngx_thread.h \
        src/os/unix/ngx_socket.h \
        src/os/unix/ngx_os.h \
        src/os/unix/ngx_user.h \
        src/os/unix/ngx_process_cycle.h \
        src/os/unix/ngx_linux_config.h \
        src/os/unix/ngx_linux.h \
        src/core/ngx_regex.h \
        objs/ngx_auto_config.h \
        src/http/ngx_http.h \
        src/http/ngx_http_request.h \
        src/http/ngx_http_config.h \
        src/http/ngx_http_core_module.h \
        src/http/ngx_http_cache.h \
        src/http/ngx_http_variables.h \
        src/http/ngx_http_script.h \
        src/http/ngx_http_upstream.h \
        src/http/ngx_http_upstream_round_robin.h \
        src/http/ngx_http_busy_lock.h \
        src/http/modules/ngx_http_ssi_filter_module.h
SOURCES = src/core/nginx.c \
        src/core/ngx_log.c \
        src/core/ngx_palloc.c \
        src/core/ngx_array.c \
        src/core/ngx_list.c \
        src/core/ngx_hash.c \
        src/core/ngx_buf.c \
        src/core/ngx_queue.c \
        src/core/ngx_output_chain.c \
        src/core/ngx_string.c \
        src/core/ngx_parse.c \
        src/core/ngx_inet.c \
        src/core/ngx_file.c \
        src/core/ngx_crc32.c \
        src/core/ngx_murmurhash.c \
        src/core/ngx_md5.c \
        src/core/ngx_rbtree.c \
        src/core/ngx_radix_tree.c \
        src/core/ngx_slab.c \
        src/core/ngx_times.c \
        src/core/ngx_shmtx.c \
        src/core/ngx_connection.c \
        src/core/ngx_cycle.c \
        src/core/ngx_spinlock.c \
        src/core/ngx_cpuinfo.c \
        src/core/ngx_conf_file.c \
        src/core/ngx_resolver.c \
        src/core/ngx_open_file_cache.c \
        src/core/ngx_crypt.c \
        src/event/ngx_event.c \
        src/event/ngx_event_timer.c \
        src/event/ngx_event_posted.c \
        src/event/ngx_event_busy_lock.c \
        src/event/ngx_event_accept.c \
        src/event/ngx_event_connect.c \
        src/event/ngx_event_pipe.c \
        src/os/unix/ngx_time.c \
        src/os/unix/ngx_errno.c \
        src/os/unix/ngx_alloc.c \
        src/os/unix/ngx_files.c \
        src/os/unix/ngx_socket.c \
        src/os/unix/ngx_recv.c \
        src/os/unix/ngx_readv_chain.c \
        src/os/unix/ngx_udp_recv.c \
        src/os/unix/ngx_send.c \
        src/os/unix/ngx_writev_chain.c \
        src/os/unix/ngx_channel.c \
        src/os/unix/ngx_shmem.c \
        src/os/unix/ngx_process.c \
        src/os/unix/ngx_daemon.c \
        src/os/unix/ngx_setproctitle.c \
        src/os/unix/ngx_posix_init.c \
        src/os/unix/ngx_user.c \
        src/os/unix/ngx_process_cycle.c \
        src/os/unix/ngx_linux_init.c \
        src/event/modules/ngx_epoll_module.c \
        src/os/unix/ngx_linux_sendfile_chain.c \
        src/core/ngx_regex.c \
        src/http/ngx_http.c \
        src/http/ngx_http_core_module.c \
        src/http/ngx_http_special_response.c \
        src/http/ngx_http_request.c \
        src/http/ngx_http_parse.c \
        src/http/ngx_http_header_filter_module.c \
        src/http/ngx_http_write_filter_module.c \
        src/http/ngx_http_copy_filter_module.c \
        src/http/modules/ngx_http_log_module.c \
        src/http/ngx_http_request_body.c \
        src/http/ngx_http_variables.c \
        src/http/ngx_http_script.c \
        src/http/ngx_http_upstream.c \
        src/http/ngx_http_upstream_round_robin.c \
        src/http/ngx_http_parse_time.c \
        src/http/modules/ngx_http_static_module.c \
        src/http/modules/ngx_http_index_module.c \
        src/http/modules/ngx_http_chunked_filter_module.c \
        src/http/modules/ngx_http_range_filter_module.c \
        src/http/modules/ngx_http_headers_filter_module.c \
        src/http/modules/ngx_http_not_modified_filter_module.c \
        src/http/ngx_http_busy_lock.c \
        src/http/ngx_http_file_cache.c \
        src/http/modules/ngx_http_gzip_filter_module.c \
        src/http/ngx_http_postpone_filter_module.c \
        src/http/modules/ngx_http_ssi_filter_module.c \
        src/http/modules/ngx_http_charset_filter_module.c \
        src/http/modules/ngx_http_userid_filter_module.c \
        src/http/modules/ngx_http_autoindex_module.c \
        src/http/modules/ngx_http_auth_basic_module.c \
        src/http/modules/ngx_http_access_module.c \
        src/http/modules/ngx_http_limit_req_module.c \
        src/http/modules/ngx_http_geo_module.c \
        src/http/modules/ngx_http_map_module.c \
        src/http/modules/ngx_http_split_clients_module.c \
        src/http/modules/ngx_http_referer_module.c \
        src/http/modules/ngx_http_rewrite_module.c \
        src/http/modules/ngx_http_proxy_module.c \
        src/http/modules/ngx_http_fastcgi_module.c \
        src/http/modules/ngx_http_uwsgi_module.c \
        src/http/modules/ngx_http_scgi_module.c \
        src/http/modules/ngx_http_memcached_module.c \
        src/http/modules/ngx_http_empty_gif_module.c \
        src/http/modules/ngx_http_browser_module.c \
        src/http/modules/ngx_http_upstream_ip_hash_module.c \
        objs/ngx_modules.c
