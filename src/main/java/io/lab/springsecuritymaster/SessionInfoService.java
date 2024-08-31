package io.lab.springsecuritymaster;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SessionInfoService {

    private final SessionRegistry sessionRegistry;

    public void sessionInfo() {
        for (Object principal : sessionRegistry.getAllPrincipals()) {
            List<SessionInformation> allSessions = sessionRegistry.getAllSessions(principal, false);
            StringBuilder sb = new StringBuilder();
            for (SessionInformation session : allSessions) {
                sb.append("사용자: ").append(principal).append("\n");
                sb.append("세션ID: ").append(session.getSessionId()).append("\n");
                sb.append("최종 요청 시간: ").append(session.getLastRequest()).append("\n");
            }
            System.out.println(sb);
        }
    }
}
