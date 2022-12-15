# 程序的说明
本程序主要内容为计算给定字符串的信息熵.
## 类的说明
本程序分为四个类和一个主运行类.四个类分别是Compute,InputPanel,OutputPanel,EntropyCalculatorFrame.Compute类负责主要的计算部分,InputPanel,OutputPanel类继承自JPanel类,是继承自JFrame的框架类EntropyCalculatorFrame的基础窗口.
### InputPanel类的说明
该类继承了 javax.swing 包中的 JPanel 类.InputPanel 类表示一个 GUI 面板,该面板包含两个文本字段及其对应的标签：一个用于字符串输入,另一个用于单词输入.

InputPanel 类具有一个构造函数,该构造函数初始化了 GUI 组件,并将面板的布局设置为两行一列的 GridLayout.这意味着面板将包含两行 GUI 组件,每行都包含一个标签和一个文本字段.

InputPanel 类还有两个方法：getInput() 和 getWord().这些方法用于检索输入文本字段中输入的文本.
### OutputPanel类的说明
该类继承了 javax.swing 包中的 JPanel 类.OutputPanel 类表示一个 GUI 面板,该面板包含多个输出字段和按钮.

OutputPanel 类具有一个构造函数,该构造函数初始化了 GUI 组件,并将面板的布局设置为三行一列的 GridLayout.这意味着面板将包含三行 GUI 组件.面板还具有黑色边框和可用于清除计算历史记录的 clearButton.

OutputPanel 类具有两个方法：setWordCount() 和 setEntropy().setWordCount() 方法将 outputWordCountArea 文本区域的文本设置为提供的单词计数值.setEntropy() 方法将 entropyField 文本字段的文本设置为提供的熵值,并将此值添加到计算历史记录中.

OutputPanel 类还具有 clearHistory() 方法,该方法在单击 clearButton 时调用.此方法清除计算历史记录.

定义了一个名为 displayInputString() 的方法,该方法接受两个字符串参数 inputString 和 inputWord.此方法的作用是：

1.通过调用 inputString 的 indexOf() 方法,计算 inputWord 在 inputString 中出现的次数.
2.将计算出的次数设置到 outputWordCountArea 文本区域中.

### EntropyCalculatorFrame类的说明
该类继承了 javax.swing 包中的 JFrame 类,并实现了 ActionListener 接口.EntropyCalculatorFrame 类表示一个图形用户界面（GUI）窗口,该窗口可以用于计算熵值.

EntropyCalculatorFrame 类具有一个构造函数,该构造函数初始化了 GUI 组件,并将面板的布局设置为 BorderLayout.该窗口包含一个 inputPanel 输入面板,一个 outputPanel 输出面板,一个 calculateButton 计算按钮,一个 wordCountButton 单词计数按钮,一个 comboBox 下拉列表框,以及一个 saveButton 保存按钮.

EntropyCalculatorFrame 类还实现了 actionPerformed() 方法,该方法会在用户单击按钮时被调用.该方法检查是否单击了计算按钮.如果单击了计算按钮,则该方法会调用 calculateEntropy() 方法计算字符串的熵值,并将计算结果设置到 outputPanel 面板中.

如果单击了单词计数按钮,则该方法会调用 outputPanel 的 displayInputString() 方法,该方法用于计算字符串中单词出现的次数.

如果选择了下拉列表框中的某一项,则该方法会检查选择的项目是否是 "Change Button Color1" 或 "Change Button Color2".如果是,则会打开颜色选择器窗口,让用户选择一个新的颜色.选择颜色之后,会将该颜色作为背景颜色设置到 outputPanel 面板中（如果选择的是 "Change Button Color1"）,或者将该颜色作为所有按钮的背景颜色（如果选择的是 "Change Button Color2"）.

如果单击了保存按钮,则该方法会检查窗口中是否有文件路径.如果没有文件路径,则会打开文件选择器窗口,让用户选择要保存的文件路径.如果有文件路径,则会将 outputPanel 中的内容保存到该文件路径对应的文件中.
### Compute类的说明
代码中定义了一个名为Compute的类,该类有一个构造函数和两个成员方法.构造函数Compute()和Compute(String InformationString)用于创建Compute类的实例,并将entropyString字段初始化为空字符串或用户提供的信息字符串.成员方法calculateEntropy()则用于计算给定字符串的熵.

在calculateEntropy()方法中,首先分别使用HashMap类创建了两个Map对象,用于统计输入字符串中字符和数字的频率.接着,使用Java的for-each循环遍历输入字符串的每个字符,并使用Character.isDigit()方法判断该字符是否为数字.如果是数字,则使用Map的getOrDefault()方法获取该数字的当前频率,并将频率加1.如果不是数字,则同理统计该字符的频率.

最后,使用for-each循环遍历两个Map对象中的频率,并使用这些频率计算每个字符或数字在输入字符串中出现的概率.接着,计算每个字符或数字的负概率,并将这些负概率相加,得到输入字符串的熵.最后,将熵作为方法的返回值返回.