(ns ecs-sandbox.core
  (:require [reagent.core :as reagent])
  (:require-macros [cljs.core.async.macros :refer [go go-loop]]
                   [ecs-sandbox.macros :refer [component]]))


(component column [partition magnitude]
           :flexDirection partition
           :height magnitude)

(component row [partition magnitude]
           :flexDirection partition
           :width magnitude)


(component root [width height left top partition]
           :width width
           :height height
           :left left
           :top top
           :flexDirection partition)


(defonce app-state
  (reagent/atom
   {:text "Hello, what is your name? "}))


(defn page [ratom]
  [:p (:text @ratom) "FIXME"])


(defn reload []
  (reagent/render [page app-state]
                  (.getElementById js/document "app")))


(defn ^:export main []
  (reload))
