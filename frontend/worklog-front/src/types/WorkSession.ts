export interface WorkSession {
    id: string;
    title: string;
    category: "WORK" | "STUDY" | "PROJECT" | "PERSONAL";
    startAt: string;
    endAt?: string;
    durationInMinutes?: number;
    tags: string;
}