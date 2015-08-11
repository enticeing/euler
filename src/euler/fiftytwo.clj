(ns euler.fiftytwo)

(defn digits
  "Returns a set of the digits in num"
  [num]
  (set (str num)))

(defn multiples-equal
  "Returns whether or not the num and its multiples
   (x,2x,3x,4x,5x,6x) all have the same digits"
  [num]
  (= (digits num)
     (digits (* 2 num))
     (digits (* 3 num))
     (digits (* 4 num))
     (digits (* 5 num))
     (digits (* 6 num))))

(defn multiples-not-equal
  [num]
  (let [canon (digits num)]
    (if (= canon (digits (* num 2)))
      (if (= canon (digits (* num 3)))
        (if (= canon (digits (* num 4)))
          (if (= canon (digits (* num 5)))
            (if (= canon (digits (* num 6)))
              false
              true)
            true)
          true)
        true)
      true)))

(defn solution
  []
  (->>
   (iterate inc 2)
   (drop-while
    (fn [x] (not (multiples-equal x))))
   (first)
   (time)
   (println)))

(defn solution-fast
  []
  (->>
   (iterate inc 2)
   (drop-while
    (fn [x] (multiples-not-equal x)))
   (first)
   (time)
   (println)))


(defn -main
  []
  (println "Clean:\n")
  (solution)
  (println "\nFast:\n")
  (solution-fast))
