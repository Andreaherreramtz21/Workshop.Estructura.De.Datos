import java.util.Queue;
import java.util.Stack;


public class HtmlValidator {

	public static Stack<HtmlTag> isValidHtml(Queue<HtmlTag> tags) {
		Stack<HtmlTag> stack = new Stack<>();
		for (HtmlTag tag : tags) {
			if (tag.isSelfClosing()) {
				continue;
			} else if (tag.isOpenTag()) {
				stack.push(tag);
			} else if (!tag.isOpenTag()) {
				if (!stack.isEmpty()) {
					if (stack.peek().matches(tag)) {
						stack.pop();
					} else {
						return stack;
					}
				} else {
					return null;
				}
			}
		}
		return stack;
	}
}