## 策略模式

策略模式的定义是：定义一系列的算法，把它们一个个封装起来，并且使它们可以相互替换。

一个基于策略模式的程序至少由两部分组成。第一个部分是一组策略类，策略类封装了具体 的算法，并负责具体的计算过程。
第二个部分是环境类 Context，Context接受客户的请求，随后 把请求委托给某一个策略类。要做到这点，说明 Context中要维持对某个策略对象的引用。

```
// 错误的模式
var performanceS = function( salary ){     return salary * 4; };

var performanceA = function( salary ){     return salary * 3; };

var performanceB = function( salary ){     return salary * 2; };


// calculateBonus 会随着 情况的增加不断膨胀，缺乏弹性。
var calculateBonus = function( performanceLevel, salary ){

    if ( performanceLevel === 'S' ){         return performanceS( salary );     }

    if ( performanceLevel === 'A' ){         return performanceA( salary );     }

    if ( performanceLevel === 'B' ){         return performanceB( salary );     }

};

calculateBonus(  'A' , 10000 );    // 输出：30000
```