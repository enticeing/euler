(ns euler.three
  (:require [clojure.math.numeric-tower :as math]))

(defn primes
  "Returns a lazy sequence of all the prime numbers in seq"
  [seq]
  (cons (first seq)
        (lazy-seq
         (primes
          (filter
           (fn [x] (not (= (rem x (first seq)) 0)))
           seq)))))

(defn primes-below
  "Returns a sequence of all the prime numbers below n"
  [n]
  (remove nil
          (cons 2 (primes (range 3 n 2)))))

(defn prime-factors
  "Returns the prime factors of n."
  [n]

  ;; We only need the primes less than (ceil (sqrt n))
  (filter (fn [x] (= 0 (rem n x)))
          (primes-below n))))

(defn greatest-prime-factor
  "Returns the greatest prime factor of n"
  [n]
  (last (prime-factors n)))

(defn -main
  []
  (println "Hello, world!"))
