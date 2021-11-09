// adds default security level to new task in chosen project
import com.atlassian.jira.component.ComponentAccessor
import com.atlassian.jira.event.type.EventDispatchOption
import com.atlassian.jira.issue.IssueManager;
import com.atlassian.jira.issue.Issue;
import com.atlassian.jira.issue.security.IssueSecurityLevel;
import com.atlassian.jira.issue.security.IssueSecurityLevelManager;

def issue_key=event.getIssue().getKey()

def issue = ComponentAccessor.getIssueManager().getIssueObject(issue_key)
issue.setSecurityLevelId(10301)

def user = ComponentAccessor.getJiraAuthenticationContext().getLoggedInUser()
def issueManager = ComponentAccessor.getIssueManager()

issueManager.updateIssue(user,issue,EventDispatchOption.DO_NOT_DISPATCH,true)
