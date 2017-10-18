(ns gotry.macros
  #?(:cljs (:require-macros [cljs.core.async.macros :refer [go]])))

#?(:cljs (defmacro gotry [& body] 
           `(go 
              (try 
                ~@body 
                (catch js/Object e# 
                  (prn "An exception has occured"))))))
