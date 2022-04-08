# AWS Stock Price Analyzer

A brute force solution to what might be an interview question.

The simplistic complexity analysis is O(n^2), but in reality, it is actually
less than O((n^2)/2) because the inner loop in the analyze function is bound by
the index of the outer loop, since you cannot sell a stock before you buy it.

Well, technically you can, be we're not trying to create a stock shorting
algorithm. I tend to think of shorting stocks as having the ability to print
infinite debt. That isn't very interesting to me.
