(ns gotry.macros
  (:require [cljs.core.async])
  (:require-macros [cljs.core.async.macros :refer [go]]))

(defmacro gotry [& body] 
  `(go 
     (try 
       ~@body 
       (catch js/Object e# 
         (prn "An exception has occured")))))
