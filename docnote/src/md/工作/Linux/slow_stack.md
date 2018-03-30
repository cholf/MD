###  slow  stack


#!/bin/sh
#changed MIao

PROG=`basename $0`

JAVA_HOME=/home/q/java/default
WEB_HOME=/home/q/www


jstack="$JAVA_HOME/bin/jstack"

usage() {
        cat <<EOF
Usage:
        ${PROG} <pid|webapp> [<count>]
        Find out the highest cpu consumed threads of java, and print the stack of these threads.
Example:
        ${PROG} twell 50
EOF
    exit $1
}

redEcho() {
    if [ -c /dev/stdout ] ; then
        # if stdout is console, turn on color output.
        echo -e "\033[1;31m$@\033[0m"
    else
        echo "$@"
    fi
}


printStackOfThreads() {
    while read threadLine ; do

        threadId=`echo ${threadLine} | awk '{print $1}'`
        threadId0x=`printf %x ${threadId}`
        pcpu=`echo ${threadLine} | awk '{print $2}'`

        jstackFile=/tmp/${uuid}_${javaid}

        [ ! -f "${jstackFile}" ] && {
            sudo -u tomcat $jstack ${javaid} > ${jstackFile} || {
                redEcho "Fail to jstack java process ${javaid}"
                rm ${jstackFile}
                continue
            }
        }

        redEcho "The stack of busy(${pcpu}%) thread(${threadId}/0x${threadId0x}) of java pid(${javaid}) all times($3):"
        sed "/nid=0x${threadId0x}/,/^$/p" -n ${jstackFile}
    done

}

if echo $1 | grep -q "$WEB_HOME"
then
                export CATALINA_BASE=$1
else
                export CATALINA_BASE=$WEB_HOME/$1
fi

if [ -e $CATALINA_BASE/conf/server.xml ]
then
                javaid=`ps aux |grep "java"|grep "Dcatalina.base=$CATALINA_BASE "|grep -v "grep"|awk '{ print $2}'`
else
                javaid=`ps -eo pid | grep "^$1$"`
fi

if [ -z "$javaid" ] ; then
        redEcho "process ($1) not found !"
        usage 1;
fi

if [ -z "$2" ] ; then
        count=1000
else
        (( count = $2 +7 ))
fi

uuid=`date +%s`_${RANDOM}_$$

top -p $javaid -H -n 1 -b | sed -n "8,${count}p" | awk '{print $1,$9,$11}' | printStackOfThreads

rm /tmp/${uuid}_*
