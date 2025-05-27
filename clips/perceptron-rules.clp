(deftemplate perceptron
   (slot w1)
   (slot w2)
   (slot bias)
   (slot gateType))

(defrule check-and
   (perceptron (w1 ?w1) (w2 ?w2) (bias ?b) (gateType "AND"))
   =>
   (printout t "Activando regla para AND..." crlf)
   (printout t "AND Gate Detected" crlf)
   (printout t "Decision boundary: " 
       (format nil "%.2f" ?w1) "x + " 
       (format nil "%.2f" ?w2) "y + " 
       (format nil "%.2f" ?b) " >= 0" crlf))

(defrule check-or
   (perceptron (w1 ?w1) (w2 ?w2) (bias ?b) (gateType "OR"))
   =>
   (printout t " Activando regla para OR..." crlf)
   (printout t " OR Gate Detected" crlf)
   (printout t "Decision boundary: " 
       (format nil "%.2f" ?w1) "x + " 
       (format nil "%.2f" ?w2) "y + " 
       (format nil "%.2f" ?b) " >= 0" crlf))

(defrule debug-perceptron
   (perceptron (w1 ?w1) (w2 ?w2) (bias ?b) (gateType ?gt))
   =>
   (printout t " Debug: Perceptron received -> w1=" 
       (format nil "%.2f" ?w1) ", w2=" 
       (format nil "%.2f" ?w2) ", bias=" 
       (format nil "%.2f" ?b) ", gateType=" ?gt crlf))
