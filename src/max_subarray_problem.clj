(ns max-subarray-problem
  (:use [clojure.test]))

(defn max-sum
  ([coll]
   (max-sum coll 0 0))
  ([coll local-max global-max]
   (if (empty? coll)
     global-max
     (let [element (first coll)
           local-max (max element (+ element local-max))]
       (if (> local-max global-max)
         (recur (rest coll) local-max local-max)
         (recur (rest coll) local-max global-max))))))

(testing "Maximum subarray sum"
   (is (= 65 (max-sum [-10 53 -12 24 -3]))))
