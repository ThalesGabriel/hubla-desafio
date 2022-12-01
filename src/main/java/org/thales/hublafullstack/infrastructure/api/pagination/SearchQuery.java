package org.thales.hublafullstack.infrastructure.api.pagination;

public record SearchQuery(
        int page,
        int perPage
) {
}
