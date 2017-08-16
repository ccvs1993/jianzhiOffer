package whiteBook.algorithm.dp;

/**
 * 现在有一个马戏团，我们获得了马戏团中每个人的身高体重。
 * 马 戏团要表演“人塔”，要求在上层的人比下面的人更轻并且更矮，求 “人塔”的最大高度。
 *
 * tips:
 * 将 People 以 Height 进行排序，在高度相同的情况 下，按照 Weight 排序。
 * 这样，把问题划归为以 Weight 为基准的 LIS （Longest Increasing Subsequence）问题
 * （因为选出的序列自然满 足高度递增），这样就与例题 8 无甚区别。
 */
public class No10 {
}
