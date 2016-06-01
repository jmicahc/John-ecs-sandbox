(ns ecs-sandbox.macros)

(print "hello world")

(defmacro component [name params & r]
  `(defn ~name ~params
     (cljs.core/js-obj "name" ~(keyword (clojure.core/name name)) ~@r)))


