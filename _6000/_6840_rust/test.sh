#!/bin/sh
rustc src/main.rs --out-dir bin/
CASE_CNT=`expr $(ls -l tc | grep ^- | wc -l) / 2`
for i in $(seq 1 ${CASE_CNT}); do
    res=$(bin/main < tc/${i}.in)
    ans=$(cat tc/${i}.out)
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
