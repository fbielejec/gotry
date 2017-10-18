(ns gotry.macros)

(defmacro gotry [& body] 
  `(cljs.core.async.macros/go
     (try 
       ~@body 
       (catch js/Object e# 
         (prn "An exception has occured")))))


