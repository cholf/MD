## cut

less /home/q/www/f_fuwu_fuwutouch/logs/catalina.out   | grep  "referer:null" | cut -d " " -f 8  | sort |uniq

grep -v 排除
