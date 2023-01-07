#!/bin/sh
for i in $(seq 1 ${4}); do
    res=$(${2} ${3} < ${1}/${i}.in)
    ans=$(cat ${1}/${i}.out)
    if [ "${res}" == "${ans}" ]; then
        echo "case #${i}: OK"
    else
        echo "case #${i}: ERR"
        echo "accepted:"
        echo "${ans}"
        echo "wrong answer:"
        echo "${res}"
    fi
done
